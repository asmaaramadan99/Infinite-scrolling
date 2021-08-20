
import {BrowserRouter as Router , Switch ,Route,Link } from 'react-router-dom';
import Welcome from './Components/Welcome'
import LoadHook from './Services/LoadHook'

function App() {
  return (
    <Router>
    <div className="App">
      <Switch>
      <Route exact path="/" component={Welcome}/>
      <Route exact path="/employee" component={LoadHook}/>

      </Switch>
    </div>
    </Router>
  );
}
export default App;