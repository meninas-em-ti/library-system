/// <reference types="cypress" />
describe('example to-do app', () => {
    beforeEach(() => {
      cy.visit('http://localhost:8080/courses/timetable')
    })

      describe('library system', () => {
        it('login successfully', () => {
          cy.get('#login.button').click()
          cy.get('#name').type('Admin')
          cy.get('#password').type('Admin@123')
          cy.get('button').contain('Login').click
          cy.title().should('include','My account - My store')
        })

        it('unregistered user', () => {
          cy.get('#login.button').click()
          cy.get('#name').type('User02')
          cy.get('#password').type('123456')
          cy.get('button').contain('Login').click
        })
      
        it('wrong password', () => {
          cy.get('#login.button').click()
          cy.get('#name').type('User01')
          cy.get('#password').type('123457')
          cy.get('button').contain('Login').click
        })
      
      })
})