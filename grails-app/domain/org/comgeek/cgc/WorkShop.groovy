package org.comgeek.cgc

class WorkShop {
	
	String title
	Date start
	Date end
	String place
	String detail
	String owner
	String mail
	String password
	
    static constraints = {
		title(blank : false, maxSize: 64)
		start(blank: false)
		end(blank: false)
		place(maxSize: 64)
		detail(maxSize: 256)
		owner(maxSize: 32)
		mail(email: true)
		password(maxSize: 32)
    }
}
