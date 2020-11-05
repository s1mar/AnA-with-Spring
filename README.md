# Authentication And Authorization
In this project, I've strived to demonstrate Authentication and Authorization using Spring. The context or example is of a stock market, where an agent can have one or more privileges out of these:
    - **CAN_VIEW** : Can only view available stock options
    - **CAN_BUY_SELL**: Can Buy/Sell stock options

### Setup
   MySql is being use as the database, please add your database name and credentials as shown below:
   ![Image application properties](https://github.com/s1mar/AnA-with-Spring/blob/main/imgs/appprop.png?raw=true)

### Demo!
- Run the Main.java file to launch the application, and navigating to port 8080 of the local host will open up login screen
        ![Image application properties](https://github.com/s1mar/AnA-with-Spring/blob/main/imgs/login.jpg?raw=true)
  
- Now, for the purpose of this demonstration, I've created two accounts, each with different elevations of Authorizations.
- | Username  | Password        |  Authority |
  |----------|:-------------:|------:|
  | Simar |  bez3 | CAN_VIEW |
  | James |    abcd123   |   CAN_BUY_SELL |

    As you can see, Simar has less authority than James. For, James also has permission Buy/Sell stock options, not just view them.
    ![Image login simar](https://github.com/s1mar/AnA-with-Spring/blob/main/imgs/login_simar.jpg?raw=true)
    
    
### Security Tactics
 * **Authentication** : A login flow is followed to authenticate the user, and let them on the main page.
 * **Authorization & Limit Exposure** : The user(stock agent), can have either of the two permissions, depending on their authority:     
     * CAN_VIEW : Can only view available stock options
     * CAN_BUY_SELL: Can Buy/Sell stock options
 * **Data Confidentiality** : Algorithms like BCRYPT are used to encrpyt passwords before using them or storing them in the database.