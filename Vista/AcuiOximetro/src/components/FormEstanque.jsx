import React from 'react'
import { View, StyleSheet } from 'react-native'
import Constants from 'expo-constants'

import DropdownMenu from './DropdownMenu'
import Input from './Input'
import { fetchData } from '../api/FetchData'
import { TIPO_ESTANQUE } from '../utils/TipoEstanque'

// const especies = fetchData(`http://${Constants.expoConfig.extra.hostApi}:8080/api/v1/estanques/1`)

const FormEstanque = () => {
  console.log(Object.values(TIPO_ESTANQUE))

  return (
    <View style={styles.container}>
      <DropdownMenu title='Especie de Pescado' data={Object.values(TIPO_ESTANQUE)} />
      <DropdownMenu title='Tipo de Estanque' data={Object.values(TIPO_ESTANQUE)} />
      <Input placeholder='Cantidad de peces' />
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
