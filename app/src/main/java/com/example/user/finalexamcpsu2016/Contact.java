package com.example.user.finalexamcpsu2016;

/**
 * Created by User on 18/12/2559.
 */

    public class Contact {

        private String mname;
        private String musername;
        private String mpassword;




        public Contact(String name, String username, String pass){
            this.mname = name;
           this.musername=username;
            this.mpassword= pass;

        }


        public String getname() {

            return mname;
        }

        public String getusername() {

            return musername;
        }

        public  String getpass()
        {

            return mpassword;
        }
}
