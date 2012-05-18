package ar.edu.untdf

import org.springframework.dao.DataIntegrityViolationException

class ObraController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
    
    def listarObras(){
        
        
    }

    def add(){
        def artista = Artista.get(params.id)
        redirect(action: "create", id: artista.id)
    }
    
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [obraInstanceList: Obra.list(params), obraInstanceTotal: Obra.count()]
    }

    def create() {
        [obraInstance: new Obra(params)]
    }

    def save() {
        def obraInstance = new Obra(params)
        if (!obraInstance.save(flush: true)) {
            render(view: "create", model: [obraInstance: obraInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'obra.label', default: 'Obra'), obraInstance.id])
        redirect(action: "show", id: obraInstance.id)
    }

    def show() {
        def obraInstance = Obra.get(params.id)
        if (!obraInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "list")
            return
        }

        [obraInstance: obraInstance]
    }

    def edit() {
        def obraInstance = Obra.get(params.id)
        if (!obraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "list")
            return
        }

        [obraInstance: obraInstance]
    }

    def update() {
        def obraInstance = Obra.get(params.id)
        if (!obraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (obraInstance.version > version) {
                obraInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'obra.label', default: 'Obra')] as Object[],
                          "Another user has updated this Obra while you were editing")
                render(view: "edit", model: [obraInstance: obraInstance])
                return
            }
        }

        obraInstance.properties = params

        if (!obraInstance.save(flush: true)) {
            render(view: "edit", model: [obraInstance: obraInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'obra.label', default: 'Obra'), obraInstance.id])
        redirect(action: "show", id: obraInstance.id)
    }

    def delete() {
        def obraInstance = Obra.get(params.id)
        if (!obraInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "list")
            return
        }

        try {
            obraInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'obra.label', default: 'Obra'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
