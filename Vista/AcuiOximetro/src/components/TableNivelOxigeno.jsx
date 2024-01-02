import React from 'react'
import { View, Text, StyleSheet } from 'react-native'

const TableNivelOxigeno = ({ nivelesOxigeno }) => {
  return (
    <View style={styles.containerTable}>
      <View style={styles.containerRow}>
        <View style={[styles.itemCol, styles.borderRight]}>
          <Text>Hora</Text>
        </View>
        <View style={styles.itemCol}>
          <Text>Mg/L</Text>
        </View>
      </View>
      {nivelesOxigeno.map((item, index) => (
        <View key={index} style={[styles.containerRow, styles.borderTop]}>
          <View style={[styles.itemCol, styles.borderRight]}>
            <Text>{item.hora}</Text>
          </View>
          <View style={styles.itemCol}>
            <Text>{item.nivelOxigeno}</Text>
          </View>
        </View>
      ))}
    </View>
  )
}

const styles = StyleSheet.create({
  containerTable: {
    width: '100%',
    borderWidth: 1,
    borderRadius: 5,
    justifyContent: 'center'
  },
  containerRow: {
    width: '100%',
    flexDirection: 'row'
  },
  itemCol: {
    width: '50%',
    height: 35,
    justifyContent: 'center',
    alignItems: 'center'
  },
  borderRight: {
    borderRightWidth: 1
  },
  borderTop: {
    borderTopWidth: 1
  }
})

export default TableNivelOxigeno
