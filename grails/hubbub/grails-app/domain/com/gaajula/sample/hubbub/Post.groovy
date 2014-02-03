package com.gaajula.sample.hubbub

class Post {
	String content
	Date dateCreated

	static constraints = { content blank:false }

	//When the User is DELETED, all the POST objects are DELETE too
	static belongsTo = [user : User]
	static mapping = { sort dateCreated:"desc" }
	static hasMany = [tags : Tag]
	
	String toString() {
		return content
	}
}