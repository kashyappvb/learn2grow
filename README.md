Assumptions :

Tax : 5% of base-price for Indians and 7% of base-price for non Indians for a course
Conversion Fee : 3% of base-price for non Indians

Prices for course are sent with breakup so that it can be used further anywhere instead of sending total in description page and breakup in checkout page. Displaying price the way we want can be handled in Frontend.



To get all Course Details :
GET localhost:8080/courses

To Add a course :

POST localhost:8080/courses
REQUEST 1 : 

{
        "courseName": "Course 5",
        "price": {
            "basePrice": 0,
            "pricingStratergy": "FREE"
        }
}

REQUEST 2 :
{
        "courseName": "Course 2",
        "price": {
            "basePrice": 150,
            "pricingStratergy": "ONE_TIME"
        }
}

Note : If pricingStratergy is FREE, even if basePrice is non zero while adding course. it saves basePrice as 0.
Field Level validations are handled in orders API(LOCATION REQUIRED). Here we assume course is added with proper data.
--------------------------------------------------------

To get price for a course :

GET /courses/{courseId}/price?location=US
By Default we are taking location as IND
Success Response :
For IND
-----------
 {
    "basePrice": 0,
    "pricingStratergy": "FREE",
    "tax": 0,
    "conversionFee": 0
}
-----------
{
    "basePrice": 150,
    "pricingStratergy": "ONE_TIME",
    "tax": 7.5,
    "conversionFee": 0
}
------------
For US
------------
{
    "basePrice": 150,
    "pricingStratergy": "ONE_TIME",
    "tax": 10.5,
    "conversionFee": 4.5
}
-------------
Failure Response : 
 {
    "code": 404,
    "msg": "COURSE_NOT_FOUND",
    "date": "2020-11-21T19:01:44.31",
    "details": [
        "Further Details can be passed here"
    ]
}

--------------------------------------------------------

Order/Checkout API :

Mandatory to send Course ID and Location in body.

POST localhost:8080/orders

Request Body
Proper Request Body and Response : 
Request (Course is FREE):
{
	"courseId":1,
	"location":"US"
}
Response :

{
    "orderId": 1,
    "courseId": 1,
    "basePrice": 0,
    "tax": 0,
    "conversionFee": 0,
    "total": 0,
    "location": "US"
}

if Course is NOT FREE and Location is not IND (Conversion Fee is added)
Response :
{
    "orderId": 3,
    "courseId": 2,
    "basePrice": 150,
    "tax": 10.5,
    "conversionFee": 4.5,
    "total": 165,
    "location": "US"
}

If Request does not contain Course ID or Locaton,then Response :

{
    "code": 404,
    "msg": "COURSE_NOT_FOUND",
    "date": "2020-11-21T19:41:41.194",
    "details": [
        "Further Details can be passed here"
    ]
}


{
    "code": 888,
    "msg": "LOCATION_NEEDED",
    "date": "2020-11-21T19:41:55.61",
    "details": [
        "Further Details can be passed here"
    ]
}