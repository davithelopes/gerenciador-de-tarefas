cat > /home/kkzy/projetos/gerenciador-de-tarefas/README.md << 'EOF'
# Gerenciador de Tarefas Pessoais

## Descrição
Sistema desenvolvido com auxílio de IA generativa para gerenciar tarefas do dia a dia. O usuário pode adicionar tarefas com diferentes prioridades, visualizar a lista e marcar tarefas como concluídas.

## Requisitos Funcionais
- RF01: O usuário deve poder adicionar uma tarefa informando título, descrição e prioridade (Normal ou Urgente)
- RF02: O usuário deve poder visualizar todas as tarefas cadastradas em uma lista
- RF03: O usuário deve poder marcar uma tarefa como concluída
- RF04: O sistema deve exibir a prioridade de cada tarefa na lista
- RF05: O sistema deve alertar o usuário caso tente adicionar uma tarefa sem título
- RF06: O sistema deve alertar o usuário caso tente concluir uma tarefa sem selecioná-la

## Tecnologias
- Java 17
- Swing (interface gráfica)

## Como executar
```bash
javac -d bin src/tarefas/*.java
java -cp bin tarefas.GerenciadorGUI
```

## Conceitos de POO utilizados
- **Herança**: TarefaUrgente e TarefaNormal herdam de Tarefa
- **Encapsulamento**: Atributos privados com getters e setters
- **Polimorfismo**: Método getPrioridade() sobrescrito nas subclasses
- **Abstração**: Classe Tarefa abstrata
EOF
