/// <reference types="cypress" />

describe('example to-do app', () => {
    beforeEach(() => {
      cy.visit('http://localhost:8080/courses/timetable')
    });

    it('login successfully', () => {
        cy.get('#btn-login').contains("Login").click()
        cy.get('#name').type('Admin')
        cy.get('#password').type('Admin@123')
    })

});
