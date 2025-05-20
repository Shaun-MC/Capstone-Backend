import React from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../../contexts/authContext'

const Header = () => {
    
    return (
        <div className='flex flex-row gap-x-2 w-full z-20 fixed top-0 left-0 h-14 border-b place-content-center items-center bg-gray-200'>
            <div className='text-sm text-blue-600 bold' to={'/login'}>Window Butlers</div>
            <div className='text-sm text-blue-600 italics' to={'/register'}>More Then Window Cleaning</div>
        </div>
    )
}

export default Header