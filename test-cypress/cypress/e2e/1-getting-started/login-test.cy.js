/// <reference types="cypress" />

describe('example to-do app', () => {
    beforeEach(() => {
      cy.visit('http://localhost:8080/courses/timetable')
    });

    it('login successfully', () => {
        cy.get('#btn-login').contains("Login").click()
        cy.get('#name').type('user01')
        cy.get('#password').type('123456')
    })

});
