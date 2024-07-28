# HealthCare Appointment System

I have developed an Heath Care appointment system using spring boot project 
## Description

We can register the patient details and can  book an appointment with the doctor, cancel the appointment and we can get the patient and all the appointment details.

## Getting Started


### Installing

* Need to install lombok 
* Used In memory database 

## Executing Application

Import the project with existing maven project and build the application.
once build completed execute HealthCareApplication.java file as java application to bootstrap the application. application will run on default port number 8080.


## Mappings and inputs : 

## Register the patient details

Post : http://localhost:8080/addpatient  
Input Json :  {"name":"krish",
"age":28,
"email":"veni@gmail.com",
"complaint" :"Headache",
"type" :"IN"
};


## Retrieve Patient Details
get : http://localhost:8080/patient/1(PatientId)

## Get All appointments 
get : http://localhost:8080/allappointments

## Book an appointment
post : http://localhost:8080/bookappointment
Input Json :{ "patientId": 1, 
"patientName": "krish",
 "doctorsName": "Pooja",
 "appointmentOn": "2024-05-28"
  }
 
## get particular appointment
get : http://localhost:8080/appointment/1(appointmentId)
## cancel an appointment 
delete : http://localhost:8080/cancelappointment/1(appointmentId)
## update an appointment
put : http://localhost:8080/updateappointment
Input Json : {
"appointmentId":1,
"patientId": 1,
"patientName":"krish",
"doctorsName":"Veni",
"appointmentOn":"2024-05-30"
 }
 
 
## Test case :

Added Test cases to book an appointment with registered patient for successful appointment 

Added Test cases to book an appointment without registering patient for negative case







