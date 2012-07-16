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
				detail:"aaa", owner:'陣内一喜', mail:'kaz.jinnai@nttcom.co.jp', password:'1111')
		assert target.validate()
	}

	@Test
	void blank制約() {
		def target = new WorkShop(title:'', start:new Date(), end:new Date(), place:'', detail:'', owner:'', mail:'', password:'')
		assert !target.validate()
		assert target.errors.allErrors.size() == 4
		assert target.errors['title'] == 'blank'
		assert target.errors['place'] == 'blank'
		assert target.errors['owner'] == 'blank'
		assert target.errors['mail'] == 'blank'
	}

	@Test
	void nullable制約() {
		def target = new WorkShop()
		assert !target.validate()
		assert target.errors.allErrors.size() == 8
		assert target.errors['title'] == 'nullable'
		assert target.errors['start'] == 'nullable'
		assert target.errors['end'] == 'nullable'
		assert target.errors['place'] == 'nullable'
		assert target.errors['detail'] == 'nullable'
		assert target.errors['owner'] == 'nullable'
		assert target.errors['mail'] == 'nullable'
		assert target.errors['password'] == 'nullable'
	}

	@Test
	void 長さ制約OK() {
		def target = new WorkShop(title:'あ'*64, start:new Date(), end:new Date(),
				place:"い"*64, detail:"う"*256, owner:"え"*32, mail:'aa@aa.com',
				password:'1'*4)
		assert target.validate()
	}
	
	@Test
	void 長さ制約違反() {
		def target = new WorkShop(title:'あ'*65, start:new Date(), end:new Date(),
				place:"い"*65, detail:"う"*257, owner:"え"*33, mail:'aa@aa.com',
				password:'1'*5)
		assert !target.validate()
		assert target.errors.allErrors.size() == 5
		assert target.errors['title'] == 'maxSize'
		assert target.errors['place'] == 'maxSize'
		assert target.errors['detail'] == 'maxSize'
		assert target.errors['owner'] == 'maxSize'
		assert target.errors['password'] == 'matches'
	}
}
