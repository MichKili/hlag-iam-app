#hlag-iam-app

##Problem description
Bob wants to check and compare historical rates between EUR and USD. He also wants to be able to retrieve a list of all previous searches that he did in the past.
###Exercise
Create a Java application that provides two REST API endpoints and has a database connection to support Bob’s requirements: \
1. First that will accept the date in format ‘YYYY-MM-DD’. The provided date should then be used to call \
   https://www.frankfurter.app/docs/ API to fetch data on the rate between EUR and USD on that particular date. \
   Following data has to be stored in the database:
* rate value between EUR and USD,
* date on which this rate was present,
* a timestamp of the search operation.
  The endpoint should return in the response only the value of the rate between EUR and USD on the provided date.
  The second endpoint should return a list of all historical searches.\
  It should return a list of objects containing the following properties:
* rate value between EUR and USD,
* date on which this rate was present,
* a timestamp.
  The list should be sorted by the rates dates.
  Anything else that is not specified can be decided on your own.

###Other information
* Task estimation is ~2-4h, but should not take longer than 4 hours
* Please use tools, frameworks and solutions you are familiar with to make it working solution
* Solution should be as simple as possible; don’t spend too much time on making it perfect
* If you stuck with sth and it takes too much time 🡪 optionally mockup possible
* We will have online video meeting with you to talk about the solution, ~15minutes
* During the meeting you will share your screen, show and describe your solution (demo)
* You can say what/how you would improve in the future (if more time given).
* We will also have Q&A session, like: why you have chosen this solution, what are possible problems/disadvantages, etc.
 
