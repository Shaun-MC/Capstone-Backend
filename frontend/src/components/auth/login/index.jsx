import React, { useState } from 'react'
import { Navigate } from 'react-router-dom'
import { doSendEmailVerification, doSignInWithEmailAndPassword, doSignInWithGoogle} from '../../../firebase/auth'
import { useAuth } from '../../../contexts/authContext'

import LoginForm from './LoginForm'
import GoogleSignInButton from './GoogleSignInButton'

const Login = () => {

    const {userLoggedIn} = useAuth()
    // TODO: double check assumptions
    //const [email, setEmail] = useState('') - Assuming their set somewhere else in the code
    //const [password, setPassword] = useState('') - Assuming their set somewhere else in the code
    const [isSigningIn, setIsSigningIn] = useState(false)
    const [errorMessage, setErrorMessage] = useState('')

    const handleEmailSignIn = async (e) => {

        e.preventDefault()

        if (!isSigningIn) {
            
            setIsSigningIn(true)
            
            await doSignInWithEmailAndPassword().catch(err => {
                setErrorMessage(err.message)
                setIsSigningIn(false)
            })

            doSendEmailVerification()
        }
    }

    const handleGoogleSignIn = async (e) => {

        e.preventDefault()

        if (!isSigningIn) {
            
            setIsSigningIn(true)

            await doSignInWithGoogle().catch(err => {
                setErrorMessage(err.message)
                setIsSigningIn(false)
            })
        }
    }

    if (userLoggedIn) return <Navigate to="/home" replace />;

    // INVESTIGATE CSS / TAILWIND CODE FORMATTING
    return (
        <main className = "w-full h-screen flex justify-center items-center">
            <div className = "w-96 text-gray-600 space-y-5 p-4 shadow-xl border rounded-xl">
                <div className= "text-center">
                    <h3 className = "text-gray-800 text-xl font-semibol sm:text-2xl">Login</h3>
                </div>

                {errorMessage && <span className = "text-red-600 font-bold"> {errorMessage}</span>}

                <LoginForm onSubmit = {handleEmailSignIn} isSigningIn = {isSigningIn} />

                <div className = "flex items-center w-full">
                    <div className = "border-b-2 flex-grow mb-2.5"></div>
                    <div className = "text-sm font-bold mx-2">OR</div>
                    <div className = "border-b-2 flex-grow mb-2.5"></div>
                </div>

                <GoogleSignInButton onClick = {handleGoogleSignIn} isSigningIn = {isSigningIn} />
            </div>
        </main>
    );
}

export default Login