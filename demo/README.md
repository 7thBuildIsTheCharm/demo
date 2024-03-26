# Additional changes required to make this project production ready:

Permanently persist data to DB:
 - Load the data to a DB only once, and not on every server boot.
 - Permanently persist the data to a DB so that it is not deleted everytime the server is down.

Consider adding caching mechanism:
 - Perhaps fetch time could be improved 

Error Messages:
 - Under current specifications, there is no need for special error consideration,
    in case such a scenario will present itself, such as a BL error, appropriate error handing can be added.

Testing:
 - Fill in all fields of Player when testing the get methods
 - Add no_content case for both apis
 - Add controller test (when more robust)