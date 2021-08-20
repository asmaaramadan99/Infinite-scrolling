import React, {useState, useEffect } from "react";
import InfiniteScroll from 'react-infinite-scroll-component';
import Employee from "../Components/Employee";
function LoadHook() {

    const [employees,setEmployees]=useState([]);
    const [loading, setLoading] = useState(true)
    const [page, setPage] = useState(2)

    useEffect(()=>{
    const getList=async()=>{
    const res=await fetch (
      `http://localhost:8080/getAll/1`
    );
    const data =await res.json();
    setEmployees(data);
    };
    getList();
    },[])
    
    console.log("employees" ,employees)
    const fetchList=async()=>{
      const res=await fetch (
        `http://localhost:8080/getAll/${page}`
      );
      const data =await res.json();
      return data;     
    };

    const fetchData=async()=>{
     const list =await fetchList();
     setEmployees([...employees,...list])
     if (list.length === 0 || list.length<15 ) {
      setLoading(false);  
    }
    setPage(page+1);
    };
    return (
        <InfiniteScroll
        dataLength={employees.length} 
        next={fetchData}
        hasMore={loading}
        loader={<h4>Loading...</h4>}
        endMessage={
          <p style={{ textAlign: 'center' }}>
            <b>Done</b>
          </p>
        }
        >
          {employees.map((employee) => {
          
            return <Employee key={employee.id} employee={employee} />;
          
            
          })}
                 
      </InfiniteScroll>
    );
  }
  
  export default LoadHook;