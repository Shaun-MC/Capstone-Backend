import React from 'react'

import Login from "./components/auth/login/index.jsx";
import Header from "./components/header"
import Footer from "./components/footer"
import Homepage from "./components/homepage"

import { AuthProvider } from "./contexts/authContext"
import { useRoutes } from "react-router-dom";

function App() {

    const routesArray = [
        {
            path: "*",
            element: <Login />,
        },
        {
            path: "/login",
            element: <Login />,
        },
        {
            path: "/home",
            element: <Homepage />,
        },
    ];

    let routesElement = useRoutes(routesArray);

    return (
        <AuthProvider>
            <Header />
            <div className = "w-full h-screen flex flex-col"> {routesElement}</div>
            <Footer />
        </AuthProvider>
    );
}

export default App;