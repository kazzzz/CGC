package org.comgeek.cgc

class WorkShop {
	
	/** イベント名 */
	String title
	/** 開始 */
	Date start
	/** 終了 */
	Date end
	/** 開催場所 */
	String place
	/** 詳細 */
	String detail
	/** 代表者 */
	String owner
	/** 連絡先 */
	String mail
	/** 編集用パスワード */
	String password
	
    static constraints = {
		title(blank : false, maxSize: 64)
		place(blank:false, maxSize: 64)
		detail(maxSize: 256)
		owner(blank:false, maxSize: 32)
		mail(blank:false, email: true)
		password(matches:'^[0-9]{4}$')
    }
}
