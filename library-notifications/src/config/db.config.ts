
import { Sequelize } from "sequelize-typescript";
import path from "path"

export const clients_connection = new Sequelize({
  dialect: "mariadb", // Specifies the database dialect
  host: process.env.DB_HOST, // Specifies the database host
  port: parseInt(process.env.DB_PORT || '3306'),
  username: process.env.DB_USER_NAME, // Specifies the database username
  password: process.env.DB_USER_PSW, // Specifies the database password
  database: process.env.DB_CLIENTS_NAME, // Specifies the database name
  logging: false, // Disables logging of SQL queries
  models: [path.join(__dirname, '../models/clients')], // Associates the Customer model with this Sequelize instance
  dialectOptions: {
    ssl: {
      rejectUnauthorized: false,
    }
  }
});

export const xipatlani_connection = new Sequelize({
  dialect: "mariadb", // Specifies the database dialect
  host: process.env.DB_HOST, // Specifies the database host
  port: parseInt(process.env.DB_PORT || '3306'),
  username: process.env.DB_USER_NAME, // Specifies the database username
  password: process.env.DB_USER_PSW, // Specifies the database password
  database: process.env.DB_XIPATLANI_NAME, // Specifies the database name
  logging: false, // Disables logging of SQL queries
  models: [path.join(__dirname, '../models/xipatlani')], // Associates the Customer model with this Sequelize instance
  dialectOptions: {
    ssl: {
      rejectUnauthorized: false,
    }
  }
});
