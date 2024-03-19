import { Given, When, Then } from "cypress-cucumber-preprocessor/steps"

beforeEach(() => {
        cy.visit("/")
        cy.get('#btn-login').contains("Login").click()
        cy.get('#name').type(Cypress.env('user_name'))
        cy.get('#password').type(Cypress.env('password'))
        cy.get('.form-button').contains('Login').click()
        cy.get('.btn-primary').contains('New course').click()
})

Given("that there is a new course to register", () => {
    cy.get('.text-center').contains("Register a new course")
})

And("I fill in all the fields on the page", () =>{
    cy.get('#name').type('Storytime for kids')
    cy.get('#limitOfCustomers').type(10)
    cy.get('#priceOfClass').type('25')
    cy.get('#ageGroup').select('Kids').should('have.value', 'kids')
    //cy.get('select').select('Kids').should('have.value', 'kids')
    cy.get('#instructorName').type('Bruna')
    cy.get('#datetimepicker1').type('02/29/2024 11:30 PM')
})

When("I click the Register button", () => {
    cy.get('.btn-primary').contains('Register').click()
})

Then("I should see the new course in the list on the main page", () =>{
    cy.contains('Library Timetable 2022').should('be.visible')
    cy.get('tr')
    cy.get('td:contains(Storytime for kids)').last()
    cy.get('td:contains(29-02-2024 23:30)').last()
    cy.get('td:contains(25)').last()
    cy.get('td:contains(kids)').last()
    cy.get('td:contains(0)').last()
    cy.get('td:contains(Bruna)').last()
})
