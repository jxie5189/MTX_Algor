# MTX_Algor

## Introduction
This is a simple web application based on the algorithm in 
*Foster JH, Bernhardt MelanieB, Thompson PA, Smith EO, Schafer ES. Using a 
bedside algorithm to individually dose high-dose methotrexate for patients at risk for
toxicity. Journal of Pediatric Hematology/Oncology. 2017;39(1):72-76. doi:10.1097/mph.0000000000000696*. 

![papertitle.png](src%2Fmain%2Fresources%2Fstatic%2Fpapertitle.png)

## Main Algorithm 
The main algorithm provided in the paper:
![Mtx_Algor_image.jpeg](src%2Fmain%2Fresources%2Fstatic%2FMtx_Algor_image.jpeg)

## Web Application
### HomePage
![appHomePage.png](src%2Fmain%2Fresources%2Fstatic%2FappHomePage.png)

When 'MtxAlgor2Application' is run, the home page is load on to the local port 8080. 
The application takes the following parameters:
- MTX Infusion Start Date - This parameter indicates the date when methotrexate was started.This is a date datatype, user can either type in the 
month, day, and year OR use the calendar icon to select the date. 
- MTX Infusion Start Time - This parameter indicates the time when the methotrexate was started. This is a time datatype, user can either type in the
hour, minute, and either AM or PM. This parameter does not use military time. User
can also use the clock icon to select the time. 
- Last mtx level date - This parameter indicates the lastest date of methotrexate 
level available from labs. This is also a date datatype and user  
