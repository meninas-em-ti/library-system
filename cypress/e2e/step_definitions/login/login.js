import { Given, When, Then } from "cypress-cucumber-preprocessor/steps"

beforeEach(() => {
     cy.visit("/")
     cy.get('#btn-login').contains("Login").click()
});

Given("that I am an administrator and I want to log into the library system", () => {
    cy.get('.form-title').contains("Log in")

})

When("I enter my username and password", () => {
    cy.get('#name').type('Admin')
	cy.get('#password').type('Admin@123')
	cy.get('.form-button').click()
})

Then("I have a successful login", () => {
    cy.contains('Welcome!!!!').should('be.visible')
})
