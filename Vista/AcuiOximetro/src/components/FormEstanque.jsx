import React from 'react'
import { View, StyleSheet } from 'react-native'
import Constants from 'expo-constants'

import DropdownMenu from './DropdownMenu'
import Input from './Input'
import { fetchData } from '../api/FetchData'
import { TIPO_ESTANQUE } from '../utils/TipoEstanque'

const especies = fetchData(`${Constants.expoConfig.extra.hostApi}/especies/`)

const FormEstanque = ({ onFormChange }) => {
  const NOMBRE_ESPECIE = especies.read()
  const handleInputChange = (name, value) => {
    onFormChange(prevState => ({ ...prevState, [name]: value }))
  }

  return (
    <View style={styles.container}>
      <DropdownMenu
        title='Especie de Pescado'
        data={NOMBRE_ESPECIE?.map((especie) => especie.nombreEspecie)}
        onIdChange={(value) => handleInputChange('idEspecie', value)}
        onValueChange={(value) => {}}
      />
      <DropdownMenu
        title='Tipo de Estanque'
        data={Object.values(TIPO_ESTANQUE)}
        onValueChange={(value) => handleInputChange('tipoEstanque', value)}
        onIdChange={(value) => {}}
      />
      <Input
        onChangeText={(value) => handleInputChange('cantidadPeces', value)}
        placeholder='Cantidad de peces'
      />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    width: 320,
    gap: 20
  }

})

export default FormEstanque
