import { auth } from "./firebase";

import {
    createUserWithEmailAndPassword,
    signInWithEmailAndPassword,
    signInWithPopup,
    GoogleAuthProvider,
} from "firebase/auth";

export const doCreateUserWithEmailandPassword = async (email, password) => {
    return createUserWithEmailAndPassword(auth, email, password);
};

export const doSignInWithEmailAndPassword = (email, password) => {
    return signInWithEmailAndPassword(auth, email, password);
};

export const doSignInWithGoogle = async () => {
    const provider = new GoogleAuthProvider();
    const result = await signInWithPopup(auth, provider);
    //const user = result.user;

    // Add user to firestore
    return result;
};

export const doSignOut = () => {
    return auth.signOut();
};

/*
export const doPasswordReset = (email) => {
    return sendPasswordResetEmail(auth, email);
  };
  
  export const doPasswordChange = (password) => {
    return updatePassword(auth.currentUser, password);
};
*/ 

/* What's is the purpose of this function
export const doSendEmailVerification = () => {

    return sendEmailVertification(auth.currentUser, {
        url: `${window.location.origin}/home`,
    });
};
*/