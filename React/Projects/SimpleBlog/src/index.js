import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';

//BrowserRouter interacts with the History package
// Route is the react component that we can render inside any other react component that we put together inside our application
import { BrowserRouter, Route } from 'react-router-dom';

// Now that our application is made of routes, we don't really have a central "App" component anymore.
//import App from './components/app';

import reducers from './reducers';
import PostsIndex from './components/posts_index';

const createStoreWithMiddleware = applyMiddleware()(createStore);


ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <BrowserRouter>

        {/* Route component has two properties - 'path' and 'component' 

            On the given 'path', show the corresponding 'component'.

            Otherwise, there is no content showed on the screen.


          "Route may have only one child element"
              - This means we have to wrap the 'Route' with a div, I'm guessing that only ONE element can be within BrowserRouter. So 'div' acts as a single parent element.
        */}
        <div>

            {/* If we want to show a component that is always displayed across routes - we can just input it here (above or below, doesn't matter)

            <Component />
             */}

            {/* TestHeader1 */}

            <Route path="/" component={PostsIndex} />
            
            {/* TestHeader2 */}
        </div>
    </BrowserRouter>

  </Provider>
  , document.querySelector('.container'));
