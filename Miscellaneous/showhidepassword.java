if (showpassword){
            imgShowpassword.setImageResource(R.drawable.icons8_eye_blue);
            edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        else{
            imgShowpassword.setImageResource(R.drawable.icons8_eye_black);
            edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
