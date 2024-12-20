# What is Reverse Engineering?
Reverse engineering is  technique to determine how a software work due to the design and functionality of a software by working to backwarking the sofware or  decompile the software using several tools for example IDA that will decompile the software to machine code, and we can see each source code of the software what it will do and what is the result or the address of the source code if it aim to the software developer or somenone that want to gain credentials information illegally.

# How does it Works?
Reverse engineering involves deconstructing a product to understand its components, structure, and functionality. The primary goal is to gather information that can be used for various purposes such as improving product designs, troubleshooting issues, or creating compatible products. The process typically comprises several stages:
1. **Data Acquisition**:
   This initial phase involves collecting data from the object of interest. Techniques such as 3D scanning, imaging, or manual measurement are often employed to capture the physical attributes of the product. For instance, advanced technologies like nondestructive X-ray tomography are used in electronic systems to gather detailed internal structures without damaging the components [(Asadizanjani et al., 2017)](https://www.semanticscholar.org/paper/PCB-Reverse-Engineering-Using-Nondestructive-X-ray-Asadizanjani-Tehranipoor/65190853c95502afe6fd25819cf2e675837209ee).
2. **Data Preprocessing**:
   After data acquisition, the collected information is processed to create a usable model. This may involve converting point clouds obtained from scans into CAD (Computer-Aided Design) models. Various algorithms can be applied to refine these models by fitting surfaces to the raw data points [(Sofronov et al., n.d.)](https://www.semanticscholar.org/paper/Approach-for-reverse-engineering-of-complex-Sofronov-Zagorski/a57548dd0a76b7d406639233f322f5ab60953daa)
3. **Analysis and Reconstruction**:
   Once a model is created, it can be analyzed for functionality and performance characteristics. Engineers may employ simulations or physical testing to evaluate how well the reconstructed model performs compared to the original product. This step often reveals insights that can lead to improvements in design or efficiency [(Samtaş, 2013)](https://www.semanticscholar.org/paper/A-Study-of-Reverse-Engineering-Program-Based-on-Samta%C5%9F/32c265481e49cbfcfe19ed2f1790438523ee2128)

# How i Reverse The Application
In carrying out the reverse engineering process, the initial stage is needed where to decompile the application which is suspected to be somewhat suspicious, in this case I use the [decompile.com](https://decompiler.com) tools to decompile the application, after looking deeper in the [`/ReverseEnginerring/blob/master/sources/com/example/myapplicatior/SendSms.java`](https://github.com/ZahidWazifa/ReverseEnginerring/blob/master/sources/com/example/myapplicatior/SendSMS.java) section. java) I saw that the application maker created a telegram API which will be used to receive a response from the victim's cellphone that has installed the application, in this case the response received is a log of the victim's sms and mms, so that when the perpetrator wants to enter an application that requires authentication such as OTP, the sms log will be sent automatically to the perpetrator using the telegram API media that the perpetrator has entered.
with the illustration:
![image1](https://github.com/user-attachments/assets/86444174-f9d9-4373-832e-533f11ad5beb)

# What i Did
After finding these suspicious things, I tried to make requests to the server continuously, or this term is also known as Denial Of Services, which is a condition where the server is no longer able to receive requests from users, which results in the server shutting down. using the script at the path [`ReverseEnginerring/blob/master/scripts_testing/APIRequest.js`](https://github.com/ZahidWazifa/ReverseEnginerring/blob/master/scripts_testing/APIRequest.js) I got the following response from the server:
* api still accept request
  
![API run ](https://github.com/user-attachments/assets/2fb50d09-8b8f-480a-bbe5-17430bfbaa58)

* api block the Request(overrequest)
  
  ![API Down](https://github.com/user-attachments/assets/fbefb107-7423-4afe-8b65-e48086d5573b)




   
