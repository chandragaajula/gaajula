package com.gaajula.sample.hubbub

import spock.lang.*

/**
 *
 */
class UserIntegrationSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	def "Saving our first user to the database"(){
		given: "A brand new user"
		def joe = new User(loginId: 'joe', password: 'secret')
		joe.setProfile(new Profile(fullName: 'Joe Somebody', email: 'joe@somebody.com',  homepage: 'http://www.gaajula.com'))

		when: "the user is saved"
		joe.save()

		then: "it saved successfully and can be found in the database"
		joe.errors.errorCount == 0
		joe.id != null
		User.get(joe.id).loginId == joe.loginId
	}

	def "Updating a saved user changes its properties"() {
		given: "An existing user"
		def existingUser = new User(loginId: 'joe', password: 'secret').save(failOnError: true)

		when: "A property is changed"
		def foundUser = User.get(existingUser.id)
		foundUser.password = 'sesame'
		foundUser.save(failOnError: true)

		then: "The change is reflected in the database"
		User.get(existingUser.id).password == 'sesame'
	}

	def "Deleting an existing user removes it from the database"() {
		given: "An existing user"
		def user = new User(loginId: 'joe', password: 'secret')
		user.setProfile(new Profile(fullName: 'Joe Somebody', email: 'joe@somebody.com',  homepage: 'http://www.gaajula.com'))
		user.save(failOnError: true)

		when: "The user is deleted"
		def foundUser = User.get(user.id)
		foundUser.delete(flush: true)

		then: "The user is removed from the database"
		!User.exists(foundUser.id)
	}

	def "Saving a user with invalid properties causes an error"() {
		given: "A user which fails several field validations"
		def user = new User(loginId: 'chuck_norris', password: 'tiny')
		user.setProfile(new Profile(fullName: 'Joe Somebody', email: 'joe@somebody.com',  homepage: 'not-a-url'))

		when:  "The user is validated"
		user.validate()
		user.getProfile().validate()

		then:
		user.hasErrors()
		user.getProfile().hasErrors()
		"size.toosmall" == user.errors.getFieldError("password").code
		"tiny" == user.errors.getFieldError("password").rejectedValue
		"not-a-url" == user.getProfile().errors.getFieldError("homepage").rejectedValue
		!user.errors.getFieldError("loginId")
	}

	def "Recovering from a failed save by fixing invalid properties"() {
		given: "A user that has invalid properties"
		def chuck = new User(loginId: 'chuck_norris', password: 'tiny')
		chuck.setProfile(new Profile(fullName: 'Chuck Norris', email: 'chuck@norris.com',  homepage: 'not-a-url'))
		assert chuck.save()  == null
		assert chuck.hasErrors()

		when: "We fix the invalid properties"
		chuck.password = "fistfist"
		chuck.profile.homepage='http://www.chucknorrisfacts.com'

		then: "The user saves and validates fine"
		chuck.validate()
		!chuck.hasErrors()
		chuck.save()
	}

	def "Ensure a user can follow other users"() {
		given: "A set of baseline users"
		def glen = new User(loginId: 'glen', password:'password').save()
		def peter = new User(loginId: 'peter', password:'password').save()
		def sven = new User(loginId: 'sven', password:'password').save()

		when: "Glen follows Peter, and Sven follows Peter"
		glen.addToFollowing(peter)
		glen.addToFollowing(sven)
		sven.addToFollowing(peter)

		then: "Follower counts should match following people"
		2 == glen.following.size()
		1 == sven.following.size()
	}
}
