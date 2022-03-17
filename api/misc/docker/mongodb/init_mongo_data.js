print('Start #################################################################');
db.getSiblingDB('tcc-db-api')

db.createCollection('question');

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Facil",
    "operation" : "soma",
    "equation" : "1+1"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Médio",
    "operation" : "Subtração",
    "equation" : "2-2"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Médio",
    "operation" : "Multiplicação",
    "equation" : "5*5"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Dificil",
    "operation" : "divisão",
    "equation" : "5/2"
})
