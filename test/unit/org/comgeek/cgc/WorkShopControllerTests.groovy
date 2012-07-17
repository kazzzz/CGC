package org.comgeek.cgc



import org.junit.*
import grails.test.mixin.*

@TestFor(WorkShopController)
@Mock(WorkShop)
class WorkShopControllerTests {

	def populateValidParams(params) {
		params['title'] = 'タイトル'
		params['start'] = new Date()
		params['end'] = new Date()
		params['place'] = '幕張ビル'
		params['detail'] = 'セキュリティはなぜ破られたのか'
		params['owner'] = '陣内'
		params['mail'] = 'jin@example.com'
		params['password'] = '0000'
		
	}

	void testIndex() {
		controller.index()
		assert "/workShop/list" == response.redirectedUrl
	}

	void testList() {

		def model = controller.list()

		assert model.workShopInstanceList.size() == 0
		assert model.workShopInstanceTotal == 0
	}

	void testCreate() {
		populateValidParams(params)
		def model = controller.create()
		assert model.workShopInstance != null
	}

	void testSave() {
		controller.save()

		assert model.workShopInstance != null
		assert view == '/workShop/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/workShop/show/1'
		assert controller.flash.message != null
		assert WorkShop.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/workShop/list'


		populateValidParams(params)
		def workShop = new WorkShop(params)

		assert workShop.save() != null

		params.id = workShop.id

		def model = controller.show()

		assert model.workShopInstance == workShop
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/workShop/list'


		populateValidParams(params)
		def workShop = new WorkShop(params)

		assert workShop.save() != null

		params.id = workShop.id

		def model = controller.edit()

		assert model.workShopInstance == workShop
	}

	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/workShop/list'

		response.reset()


		populateValidParams(params)
		def workShop = new WorkShop(params)

		assert workShop.save() != null

		// test invalid parameters in update
		params.id = workShop.id
		params.password = 'aaa'

		controller.update()

		assert view == "/workShop/edit"
		assert model.workShopInstance != null

		workShop.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/workShop/show/$workShop.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		workShop.clearErrors()

		populateValidParams(params)
		params.id = workShop.id
		params.version = -1
		controller.update()

		assert view == "/workShop/edit"
		assert model.workShopInstance != null
		assert model.workShopInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/workShop/list'

		response.reset()

		populateValidParams(params)
		def workShop = new WorkShop(params)

		assert workShop.save() != null
		assert WorkShop.count() == 1

		params.id = workShop.id

		controller.delete()

		assert WorkShop.count() == 0
		assert WorkShop.get(workShop.id) == null
		assert response.redirectedUrl == '/workShop/list'
	}
}
