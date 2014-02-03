package com.gaajula.sample.hubbub

class Tag {
	String name
	String user

	static constraints = { name blank:false }

	static hasMany = [posts: Post]
	
	//The belongsTo field controls where the dynamic addTo*() methods can be
	//used from. We can call User.addToTags() because Tag belongs to User.
	//We can also call Post.addToTags() because Tag belongs to Post.
	//But Post doesn't belongTo Tag, so we can't call Tag.addToPosts()
	static belongsTo = [User, Post]
	
	String toString() {
		return name + ' --> ' + user
	}
}
