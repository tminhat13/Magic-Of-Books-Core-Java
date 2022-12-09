# Magic-Of-Books-Core-Java

Magic of Books is a Book store which deals with book. All the inventory of the store is been 
managed manually. Now as store is expending it is becoming difficult to manage it manually. 
Books store wants to have a book management system with following feature.

## User Stories:
1. As an User, I should be able to enter into the application using my user name
2. As an User, My user name should be checked and verified
3. As an User, if valid I should be able to see all my books (new, Favourite or 
completed)
4. As a User, I should be able to select any book by entering book Id.
5. As a User, I should be able to get book details like Author name and description.

## Instructions:

1. The User class should have following Attributes:

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| userName | String  | strore the name of the user |
| userId  | int  | unique id for the user |
| email | String | stores user email address |
| password  | String  | stores user's password |
| newBooks | ArrayList | |
| favourite | ArrayList | |
| Completed | ArrayList | |
 
The book class should have following attributes:

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| bookName | String  | strore the name of the book |
| Author name | String  | strore the name of the author |
| description | String  | Book's description |
| book Id | int  | unique id for the book |
 
2. Use Arrays to store books information in user class.
3. Create book and User as a pojo.
4. Create MagicOfBooks class to define all the functionality related methods. 
5. Use recursive menu to display all the options and inputs
6. Zero marks will be awarded if the code throws compile time error. Partial marking will be done only if the code has no compile time error

## Output
![](Output1.png)
![](Output2.png)
![](Output3.png)
![](Output4.png)
![](Output5.png)
![](Output6.png)