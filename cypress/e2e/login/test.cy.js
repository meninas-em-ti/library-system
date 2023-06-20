Given('I am a system admin') do
  cy.visit('http://localhost:8080/courses/timetable')
  cy.get('#btn-login').contains("Login").click()
end

When('When I sign in with {string} and {string}') do |string, string2|
  cy.get('#name').type('Admin')
  cy.get('#password').type('Admin@123')
  cy.get('.form-button').click()
  //cy.get('button').contain('Login').click()
end

Then('I acess the Welcome page') do
  cy.contains('Welcome!!!!').should('be.visible')
  	//cy.title().should('include','Welcome!!!!')
end

When('I sign in with <user> and <pass>') do
  pending # Write code here that turns the phrase above into concrete actions
end

Then('So I must not be authenticated') do
  pending # Write code here that turns the phrase above into concrete actions
end

Then('I should to see the message <text>') do
  pending # Write code here that turns the phrase above into concrete actions
end