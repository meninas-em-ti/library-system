import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";

Given("precondition", () => {
    cy.visit('http://localhost:8080/courses/timetable')
	cy.get('#btn-login').contains("Login").click()
})



When("action", () => {
	cy.get('#name').type('Admin')
	cy.get('#password').type('Admin@123')
	cy.get('.form-button').click()
	//cy.get('button').contain('Login').click()
})

Then("I acess the Welcome page", () => {
	cy.contains('Welcome!!!!').should('be.visible')
	//cy.title().should('include','Welcome!!!!')

})
