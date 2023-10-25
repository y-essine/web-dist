// routes/auth.js

const express = require('express');
const router = express.Router();
const User = require('../models/User');
const jwt = require('jsonwebtoken');

const axios = require('axios');

const config = {
    method: 'POST',
    loginUrl: 'http://keycloak-server:18080/auth/realms/spring-micro-main/protocol/openid-connect/token',
    registerUrl: 'http://keycloak-server:18080/auth/realms/spring-micro-main/clients-registrations/openid-connect',
    clientId: 'spring-micro-gateway',
    clientSecret: '**********',
    realm: 'spring-micro-main',
    grantType: 'password',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
}

function hashPassword(password, salt) {
    return crypto.pbkdf2Sync(password, salt, 10000, 64, 'sha512').toString('hex');
}

router.get('', async (req, res) => {
    return res.status(200).json({ message: 'All users' });
})

router.post('/keycloak', async (req, res) => {
    
    return res.status(200).json({ message: response || "Failed to fetch" });

})

// Login endpoint
router.post('/login', async (req, res) => {
    try {
        const { username, password } = req.body;
        
        const options = {
            method: config.method,
            url: config.loginUrl,
            headers: config.headers,
            data: `grant_type=${config.grantType}&client_id=${config.clientId}&client_secret=${config.clientSecret}&username=${username}&password=${password}`,
        };
    
        await axios.request(options).then(function (response) {
            return res.status(200).json(response.data || "Failed to fetch" );
        }).catch(function (error) {
            console.error(error);
        });
    } catch (error) {
        res.status(500).json({ message: 'Internal Server Error' });
    }
});

// Registration endpoint
router.post('/register', async (req, res) => {
    try {
        const { username, password } = req.body;

        const options = {
            method: config.method,
            url: config.registerUrl,
            headers: config.headers,
            data: `username=${username}&password=${password}`,
        };

        await axios.request(options).then(function (response) {
            if (response.status != 201) {
                return res.status(400).json({ message: 'Register error' });
            }
            return res.status(200).json(response.data || "Failed to fetch" );
        }).catch(function (error) {
            console.error(error);
        });
    } catch (error) {
        res.status(500).json({ message: 'Internal Server Error' });
    }
});

module.exports = router;
