import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack'
import { StatusBar } from 'expo-status-bar'

import Login from './src/screens/Login'
import Inicio from './src/screens/Inicio'
import EstanqueDetalles from './src/screens/EstanqueDetalles'

const Stack = createStackNavigator()

export default function App () {
  return (
    <NavigationContainer>
      <StatusBar style='auto' />
      <Stack.Navigator>
        <Stack.Screen name='Login' component={Login} options={{ headerShown: false }} />
        <Stack.Screen name='Inicio' component={Inicio} options={{ headerShown: false }} />
        <Stack.Screen name='EstanqueDetalles' component={EstanqueDetalles} options={{ headerShown: false }} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}
