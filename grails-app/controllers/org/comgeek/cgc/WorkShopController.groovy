package org.comgeek.cgc

import org.springframework.dao.DataIntegrityViolationException

class WorkShopController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [workShopInstanceList: WorkShop.list(params), workShopInstanceTotal: WorkShop.count()]
    }

    def create() {
        [workShopInstance: new WorkShop(params)]
    }

    def save() {
        def workShopInstance = new WorkShop(params)
        if (!workShopInstance.save(flush: true)) {
            render(view: "create", model: [workShopInstance: workShopInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'workShop.label', default: 'WorkShop'), workShopInstance.id])
        redirect(action: "show", id: workShopInstance.id)
    }

    def show() {
        def workShopInstance = WorkShop.get(params.id)
        if (!workShopInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "list")
            return
        }

        [workShopInstance: workShopInstance]
    }

    def edit() {
        def workShopInstance = WorkShop.get(params.id)
        if (!workShopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "list")
            return
        }

        [workShopInstance: workShopInstance]
    }

    def update() {
        def workShopInstance = WorkShop.get(params.id)
        if (!workShopInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (workShopInstance.version > version) {
                workShopInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'workShop.label', default: 'WorkShop')] as Object[],
                          "Another user has updated this WorkShop while you were editing")
                render(view: "edit", model: [workShopInstance: workShopInstance])
                return
            }
        }

        workShopInstance.properties = params

        if (!workShopInstance.save(flush: true)) {
            render(view: "edit", model: [workShopInstance: workShopInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'workShop.label', default: 'WorkShop'), workShopInstance.id])
        redirect(action: "show", id: workShopInstance.id)
    }

    def delete() {
        def workShopInstance = WorkShop.get(params.id)
        if (!workShopInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "list")
            return
        }

        try {
            workShopInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'workShop.label', default: 'WorkShop'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
