import React from 'react';
import Logo from '../Logo.jsx'

const Header = () => {

    return (
        <header className = "relative w-full h-64 bg-gray-300">
            <Logo className = "w-full h-full object-cover" />
        
            <div className = "text-textBlue">
                <h1 className = "text-3xl sm:text-4xl font-bold"> WINDOW BUTLERS</h1>
                <p className = "text-lg sm:text-xl italic"> More than window cleaning</p>
            </div>
        </header>
    );
}

export default Header;