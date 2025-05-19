import React from 'react';
import { ReactComponent as LogoIcon } from '../logo.svg';

const Logo = ( {className = ""}) => (
    <LogoIcon className = {className} />
);

export default Logo