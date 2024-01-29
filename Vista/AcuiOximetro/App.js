import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack'
import { StatusBar } from 'expo-status-bar'

import Login from './src/screens/Login'
import Inicio from './src/screens/Inicio'
import EstanqueDetalles from './src/screens/EstanqueDetalles'
import ModificarEstanque from './src/screens/ModificarEstanque'
import AñadirEstanque from './src/screens/AñadirEstanque'
import RegistrarUsuario from './src/screens/RegistrarUsuario'

const Stack = createStackNavigator()

export default function App () {
  return (
    <NavigationContainer>
      <StatusBar style='auto' />
      <Stack.Navigator>
        <Stack.Screen name='Login' component={Login} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
        <Stack.Screen name='Inicio' component={Inicio} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
        <Stack.Screen name='EstanqueDetalles' component={EstanqueDetalles} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
        <Stack.Screen name='ModificarEstanque' component={ModificarEstanque} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
        <Stack.Screen name='AñadirEstanque' component={AñadirEstanque} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
        <Stack.Screen name='RegistrarUsuario' component={RegistrarUsuario} options={{ headerShown: false, cardStyle: { backgroundColor: '#FFF' } }} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}
