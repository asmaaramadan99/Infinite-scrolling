import React from 'react';
import { useHistory } from 'react-router-dom';
import '../Styles/Welcome.css'
function Welcome(props) {
    const history = useHistory();

    const redirect = () => {
      history.push('/employee');
    }
  
    return (
        <div>  
            <button className= "welcome-btn" onClick={redirect} >welcome</button>
        </div>
    );
  } export default Welcome