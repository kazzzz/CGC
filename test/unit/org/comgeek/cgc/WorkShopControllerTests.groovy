package org.comgeek.cgc



import org.junit.*
import grails.test.mixin.*

@TestFor(WorkShopController)
@Mock(WorkShop)
class WorkShopControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
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
        //TODO: add invalid values to params object

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
