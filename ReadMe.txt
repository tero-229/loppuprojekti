/register - GET request
The showRegistrationPage(..) method on lines  defines a /register endpoint that handles GET requests.   This will be used to serve the view template we create in the next section.

/register - POST request
The processRegistrationForm(..) method on line X defines a /register endpoint that handles POST requests.   This will be used to save the user to our database and generate a confirmation e-mail.

We will use zxcvbn to check the strength of the password on the server-side.   This is important since a savvy user may bypass our login form and try to submit data directly to the endpoint.

/confirm - GET request
The confirmation page serves a couple purposes:  

Verify that the user who signed up is the owner of the e-mail address
Ask the user to set a password
The showConfirmationPage(..) method on line X defines a /confirm endpoint that handles GET requests.   This method will parse the token in the URL parameter in order to lookup the user.   

The form on this page also had a hidden input field containing the confirmation token.   This is used when the form is submitted and handled by the next endpoint.

Here we do client-side checking of the password strength using zxcvbn in JavaScript.

/confirm - POST request
The processConfirmationForm(..) method creates a /confirm endpoint that accepts POST requests. This method will process the submission of the password form.  This controller performs the following actions:

Checks password strength
We will use zxcvbn to check the strength of the password on the server-side. This is important since a savvy user may bypass our login form and try to submit data directly to the endpoint.

The zxcvbn library uses a score of 1-4 to represent password complexity. We reject anything below a score of 3.

Hashes the password and saves it
The hashing is done using the Bcrypt password encoder that is bundled with Spring Security.