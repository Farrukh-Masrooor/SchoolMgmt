package app.hcl.com.schoolmgmt;

import android.view.View;

public class Student {

    String firstName,middleName,lastNmae,emailID,gender,cuurAdd,permAdd,bloodgrp,citizenship,password,enrollNo;
    int phoneNo;

    Student(){

    }

    Student(String firstName,String middleName,String lastNmae,String emailID,String gender,
            String cuurAdd,String permAdd,String bloodgrp,String citizenship,String password,String enrollNo,
            int phoneNo)
    {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastNmae=lastNmae;
        this.emailID=emailID;
        this.gender=gender;
        this.cuurAdd=cuurAdd;
        this.permAdd=permAdd;
        this.bloodgrp=bloodgrp;
        this.citizenship=citizenship;
        this.password=password;
        this.phoneNo=phoneNo;

    }

    Student(String firstName,String lastNmae,String gender,
            String cuurAdd,String permAdd,String bloodgrp,String citizenship,String password,String enrollNo)
    {
        this.firstName=firstName;
        this.lastNmae=lastNmae;

        this.gender=gender;
        this.cuurAdd=cuurAdd;
        this.permAdd=permAdd;
        this.bloodgrp=bloodgrp;
        this.citizenship=citizenship;
        this.password=password;

    }


}
