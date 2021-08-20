import React from 'react';
import {Link,Redirect,useHistory} from 'react-router-dom';
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBBtn } from 'mdb-react-ui-kit';
import '../Styles/Employee.css'
function Employee({employee:{firstName,lastName, departement, id}}) {
    return (
     
     <div>
     <MDBCard className="card" style={{ maxWidth: '22rem' }}>
     <MDBCardBody>
       <MDBCardTitle>{"Employee Number " + id }</MDBCardTitle>
       <MDBCardText>
         {"first name " + firstName }
        
       </MDBCardText>
       <MDBCardText>{"last name " + lastName}</MDBCardText>
       <MDBCardText>{"departement " + departement}</MDBCardText>
       <MDBBtn>Button</MDBBtn>
     </MDBCardBody>
   </MDBCard>
   </div>
    
    );

  }
  export default Employee;