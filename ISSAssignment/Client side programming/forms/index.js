function validateForm(event){

    event.preventDefault();
    let isValid=true
    let errorMessages=[]

    const name=document.getElementById('name')
    const age=document.querySelector("#age")
    const contactNo=document.querySelector("#contactNo")
    const email=document.querySelector("#email")
    const city=document.querySelector("#city")
    const gender=document.querySelector('input[type="radio"]:checked')
    const languages=document.querySelector('input[type="checkbox"]:checked')
    const address=document.querySelector("#address")

    const successComponent=document.querySelector("#success")
    const errorComponent=document.querySelector("#error")

    if(name.value=='')
    {
        isValid=false
        errorMessages.push("Name is a required field")
    }
    if(age.value=='')
    {
        isValid=false
        errorMessages.push("Age is a required field")
    }
    if(contactNo.value=='')
    {
        isValid=false
        errorMessages.push("Contact no. is required field")
    }
    if(email.value=='')
    {
        isValid=false
        errorMessages.push("Email is a required field")
    }
    if(city.value==="select")
    {
        isValid=false
        errorMessages.push("City is a required field")
    }
    if(address.value=='')
    {
        isValid=false
        errorMessages.push("Address is a required field")
    }
    if(gender==null){
        isValid=false
        errorMessages.push("Gender not selected")
    }
    if(languages==null){
        isValid=false
        errorMessages.push("Languages not selected")
    }
    // console.log(errorMessages)
    if(!isValid){
        errorComponent.classList.add("error")
        errorComponent.innerHTML=''
        for(let error of errorMessages)
            errorComponent.innerHTML+=(" "+error+"<br>")  
        
    }
    else{
        errorComponent.classList.remove("error")
        errorComponent.innerHTML=''
        successComponent.classList.add("success")
        successComponent.innerHTML="Form submitted successfully"
    }

}
