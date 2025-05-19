import { useState } from "react";

const LoginForm = ({ onSubmit, isSigningIn }) => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {

        e.preventDefault();
        onSubmit(email, password);
    };

    return (
        <form onSubmit = {handleSubmit} className = "space-y-5">
            <InputField
                label = "Email"
                type = "email"
                value = {email}
                onChange = {setEmail}
                autoComplete = "email"
            />
            <InputField
                label = "Password"
                type = "password"
                value = {password}
                onChange = {setPassword}
                autoComplete = "current-password"
            />

            <button
                type = "submit"
                disabled = {isSigningIn}
                className = {`w-full px-4 py-2 text-white font-medium rounded-lg ${
                    isSigningIn ? "bg-gray-300 cursor-not-allowed" : "bg-indigo-600 hover:bg-indigo-700 hover:shadow-xl transition duration-300"
                }`}
            >
                {isSigningIn ? "Signing In..." : "Sign In"}
            </button>
        </form>
    );
};

// Will probably pull this out for later functionality search bars
const InputField = ({ label, type, value, onChange, autoComplete }) => (
    <div>
        <label className = "text-sm text-gray-600 font-bold"> {label}</label>
        <input
            type = {type}
            value = {value}
            onChange = {(e) => onChange(e.target.value)}
            autoComplete = {autoComplete}
            required
            className = "w-full mt-2 px-3 py-2 text-gray-500 bg-transparent outline-none border focus:border-indigo-600 shadow-sm rounded-lg transition duration-300"
        />
    </div>
);

export default LoginForm;