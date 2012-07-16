package org.comgeek.cgc



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(WorkShop)
class WorkShopTests {
	
	@Before
	void setUp() {
		mockForConstraintsTests(WorkShop)
	}
	
	@Test
	void 通常登録() {
		def target = new WorkShop(title:'幕張勉強会', start:new Date(), end:new Date(), place:'幕張ビル21F',
				detail:"aaa", owner:'陣内一喜', mail:'kaz.jinnai@nttcom.co.jp', password:'aaaa')
		assert target.validate()
	}
	
	@Test
	void blank制約() {
		def target = new WorkShop(title:'', start:'', end:'', place:'', detail:'', owner:'', mail:'', passowrd:'')
		assert !target.validate()
		assert target.errors['title'] == 'blank'
		println target.errors['end']
		assert target.errors['start'] == 'nullable'
	}
}
