print('Start #################################################################');
db.getSiblingDB('tcc-db-api')

db.createCollection('question');

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Facil",
    "operation" : "soma",
    "equation" : "1+1",
    "answer" : "2"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Médio",
    "operation" : "Subtração",
    "equation" : "2-2",
    "answer" : "0"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Médio",
    "operation" : "Multiplicação",
    "equation" : "5*5",
    "answer" : "25"
})

print('Insert data into question #################################################################');
db.getCollection('question').insert({
    "difficulty" : "Dificil",
    "operation" : "divisão",
    "equation" : "5/2",
    "answer" : "2.5"
})
