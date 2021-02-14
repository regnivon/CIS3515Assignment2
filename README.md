## Sign Up Form

This application consists of a single activity which allows a user to sign up for a service. The fields are 
validated upon pressing submit, and should a field be empty the user is warned and unable to submit. 
Additionally, it is checked that the password and password confirmation fields are the same. Each warning
message is specialized so that the user has more information about what is needed. Below you will find
a screenshot which displays some of these errors in action. 

The validation is done by iterating through an array list containing all the input views. Each is checked
for being filled, and if not the respective error in the error string array list is shown to the user.



![screenshot](ss.png)