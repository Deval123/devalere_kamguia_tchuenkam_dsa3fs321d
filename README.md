**Java Spring Test**

_A little ideas of what you will find._

you will find several files in the resource folder.

The _**src/main/resources/anywr.postman_collection.json**_, for testing purpose on postman.

The csv files to generate sample of data for test, or you can use json file on postman to generate those data yourself.

I have implemented some unit testing method, but some are not correct, I didn't have time to correct them totally, 
I just wanted to show you how we can implement them.

For  the list of students according to those filters, have a look of all file related to **Student** in the project.
getStudents() method in Student.Controller.java and Student.Repository.java too.

**List of resources I used**:

* My own git repository (here are some work on my personal repository) : https://github.com/Deval123/gestiondestock_back.git

    https://github.com/Deval123/gestiondestock_front.git

* for jwt:  https://jwt.io/


* Encryption Key Generator : https://www.allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx


* for debugging purpose : https://stackoverflow.com/


* for dependencies compatibilities and unit tests : https://chat.openai.com/

NB: I don't know if I was right by adding those implementations like :
validator, exceptions, custom errors ... but i taught that a clear code need that.